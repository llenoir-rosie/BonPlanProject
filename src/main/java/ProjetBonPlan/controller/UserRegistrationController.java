package ProjetBonPlan.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.model.User;
import ProjetBonPlan.repository.UserRepository;
import ProjetBonPlan.service.UserService;
import ProjetBonPlan.service.UserServiceImpl;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserRegistrationController {
    
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(path = "/registration", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registerUserAccout(@RequestBody UserRegistrationDto registrationDto) throws Exception {
        String tempEmail = registrationDto.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User user = userService.fetchUserByEmail(tempEmail);
            if ( user != null) {
                throw new Exception("User already exist!!");
            }
        }
        User user = userService.save(registrationDto);

        String src="C:/Users/cfavre/BonPlanFront/src/assets/img/defaut.jfif";
        String dest = "C:/Users/cfavre/BonPlanFront/src/assets/img/profil/" + registrationDto.getUsername() +".jfif";
        // Files.move(Paths.get(src), Paths.get(dest));
        File srcFile = new File(src);
        File destFile = new File(dest);
        Files.copy(srcFile.toPath(), destFile.toPath());

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }    
    
    @GetMapping(path = "/{username}/Details")
    public ResponseEntity<User> loginUser(@PathVariable("username") @RequestBody String username) {
        User userObj = userService.fetchUserByUsername(username);
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
    }

    @GetMapping(path="/User/ImgProfil/{username}")
    public String getImgProfil(@PathVariable("username") String username){
        System.out.println(userServiceImpl.fetchImgByUsername(username));
        return userServiceImpl.fetchImgByUsername(username);
    }

    @GetMapping(path="/verifyFile/{filename}")
    public Boolean verifyFile(@PathVariable("filename") String filename){
        File file = new File(filename);
        return file.exists();
    }

    // @Transactional
    // @Modifying
    @PutMapping(path="/updatepassword",consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePassword(@RequestBody User user){
        userServiceImpl.updatePassword(user);
}

    @PutMapping(path="/updateinfos",consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccountInfos(@RequestBody User user){
        userServiceImpl.updateAccountInfos(user);
    }

    @PutMapping(path="/updatePhoto/{Photoname}",consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePhoto(@RequestBody User userDetails, @PathVariable("Photoname") String Photoname) throws InterruptedException, IOException{
        String user = (((System.getProperty("user.home")).split("Users"))[1]).replace("\\","");
        String src = "C:/Users/" + user + "/Downloads/" + Photoname;
        String Username = userDetails.getUsername();
        
        File filepath = new File("DemoApplication.java");
        
        String path = filepath.getCanonicalPath();

        String CorrectPath = path.substring(0, path.length() - 21);
        System.out.println("Correct Path : " + CorrectPath);

        System.out.println("Path : "+ path);
        
        // String dest = CorrectPath+ "\\profile\\" + Photoname;
        String dest = "C:/Users/cfavre/BonPlanFront/src/assets/img/profil/" + Photoname;
        System.out.println("destination : " + dest);
        // String dest = "C:/Users/cfavre/ImgDatabase/profile/" + Photoname;
        File file2 = new File(dest);
        TimeUnit.SECONDS.sleep(1);
        if (file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
            Files.delete(Paths.get(dest));
        }
        TimeUnit.SECONDS.sleep(1);
        Files.move(Paths.get(src), Paths.get(dest));
        String UpdatePathImage = "../assets/img/profil/" + Photoname;
        File file_delete = new File(src);
        
        if (file_delete.exists()){
            Files.delete(Paths.get(src));
        }      
        userServiceImpl.UpdatePhoto(UpdatePathImage, Username);
    }

    @DeleteMapping(path="/deleteUser/{username}")
    public void deleteUser(@PathVariable ("username") String username){
        userServiceImpl.UserDelete(username);
    }

    
}