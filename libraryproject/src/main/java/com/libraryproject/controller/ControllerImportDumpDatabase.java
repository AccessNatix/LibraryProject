package com.libraryproject.controller;

import com.libraryproject.inportordumpbdd.AddXmlToBdd;
import com.libraryproject.inportordumpbdd.init.Init;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerImportDumpDatabase {
    
    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public ModelAndView getImportPage()
    {
        return new ModelAndView("admin_db");
    }
    
    /**
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public @ResponseBody ModelAndView importPage(@RequestParam("file") MultipartFile file)
    {
        AddXmlToBdd xmlLoader = new AddXmlToBdd();
        Map<String, byte[]> zipContents = new HashMap<>();
        
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(bytes));
                
                ZipEntry entry;
                
                while ((entry = zip.getNextEntry()) != null) {
                  int size;
                  byte[] buffer = new byte[2048];

                  FileOutputStream fos = new FileOutputStream(entry.getName());
                  BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length);

                  while ((size = zip.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, size);
                  }
                  
                  // save the current content
                  zipContents.put(entry.getName(), bytes);
                  
                  bos.flush();
                  bos.close();
                }
                
                if(zipContents.containsKey("init.xml"))
                {
                    Init init = xmlLoader.getInitConfiguration("init.xml");
                    
                    if(init != null)
                    {
                        if(zipContents.containsKey(init.getPathlibrary()))
                        {                            
                            xmlLoader.loadXmlInDatabase(init.getPathlibrary(), zipContents);
                        }
                    }
                }
                else
                {
                    Logger.getLogger(ControllerImportDumpDatabase.class.getName()).log(Level.SEVERE, "init.xml not found");
                }
      
            } catch (IOException ex) {
                Logger.getLogger(ControllerImportDumpDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return new ModelAndView("admin_db");
    }
}
