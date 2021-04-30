
package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Files;
import tn.esprit.spring.repository.Filesrep;


@Service
public class Filesservice {
  @Autowired
  private Filesrep Filesrep;
  
  public Files saveFile(MultipartFile file) {
	  String docname = file.getOriginalFilename();//if it s a garantie or a raison
	  try {
		  Files  File = new Files(docname,file.getBytes());
		  return Filesrep.save(File);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return null;
  }
  public Optional<Files> getFile(Integer fileId) {
	  return Filesrep.findById(fileId);
  }
  public List<Files> getFiles(){
	  return Filesrep.findAll();
  }
}