package ProjetBonPlan.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.activity;
import ProjetBonPlan.model.bonplan;
import ProjetBonPlan.repository.ActivityRepository;
import ProjetBonPlan.repository.BonPlanRepository;
import ProjetBonPlan.service.BonPlanService;
import aj.org.objectweb.asm.Type;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BonPlanCtrler {

    @Autowired //if multiple constructor
    private BonPlanService bonplanService;

    @Autowired
    private ActivityRepository activityRepository;
    
    @Autowired
    private BonPlanRepository bonplanRepository;

    //@return All Bons Plans (bonplan.java) that concern an activity (activity.java) of a city (cities.java)
    @GetMapping(path= "/{city}/{activity}/bonplan")
    public ResponseEntity<List<bonplan>> getBonPlan(@PathVariable("city") String city, @PathVariable("activity") String activity) {
        List<bonplan> allBP = bonplanService.getBonPlan(city, activity);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }
    
    //Create a new Bon Plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    //A refaire avec un post de l'objet et pas de ses variables séparemments
    @PostMapping(path= "/{city}/{activity}/{Photoname}/newbonplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void postBonPlan(@RequestBody bonplan newBonPlan , @PathVariable("Photoname") String Photoname) throws IOException, InterruptedException {
        System.out.println(":"+Photoname+":");
        System.out.println(Photoname.getClass().getSimpleName());
        System.out.println("defaut".getClass().getSimpleName());
        char LastChar = Photoname.charAt(Photoname.length() -1);
        if ( LastChar != 'f'){
            System.out.println("done");
            activity Act = activityRepository.findByImgActivity(newBonPlan.getActivity_type());
            Photoname = Act.getImage();
            newBonPlan.setImageBonPlan(Photoname);
        }else{
            String user = (((System.getProperty("user.home")).split("Users"))[1]).replace("\\","");
            String src = "C:/Users/" + user + "/Downloads/" + Photoname;
            File filepath = new File("DemoApplication.java");
            String path = filepath.getCanonicalPath();
            String CorrectPath = path.substring(0, path.length() - 21);
            String dest = "C:/Users/cfavre/BonPlanFront/src/assets/img/bp/" + Photoname;
            File file2 = new File(dest);
            TimeUnit.SECONDS.sleep(1);
            if (file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
                Files.delete(Paths.get(dest));
            }
            TimeUnit.SECONDS.sleep(1);
            Files.move(Paths.get(src), Paths.get(dest));
            String UpdatePathImage = "../assets/img/bp/" + Photoname;
            File file_delete = new File(src);
            
            if (file_delete.exists()){
                Files.delete(Paths.get(src));
            }  
            newBonPlan.setImageBonPlan(UpdatePathImage);
    }

        bonplanService.createNewBonPlan(newBonPlan);
    }

    //Delete a Bon plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @DeleteMapping(path= "/{city}/{activity}/{name}")
    public void deleteBonPlan(@PathVariable("name") String name) {
        bonplanService.deleteThisBonPlan(name);
    }

    @DeleteMapping(path="/deleteAccountwithBP/{username}")
    public void deleteBPfromUser(@PathVariable("username") String username){
        bonplanService.deleteBPfromUser(username);
    }

    //Update a Bon plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @PutMapping(path= "/{city}/{activity}/{Photoname}/updatePhotoBonplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateBonPlan(@RequestBody bonplan upBonPlan,@PathVariable("Photoname") String Photoname) throws IOException, InterruptedException {      
       String user = (((System.getProperty("user.home")).split("Users"))[1]).replace("\\","");
        // String Photoname = upBonPlan.getImageBonPlan();
        System.out.println("Photoname"+Photoname);
        String src = "C:/Users/" + user + "/Downloads/" + Photoname;
    

        File filepath = new File("DemoApplication.java");
        
        String path = filepath.getCanonicalPath();

        String CorrectPath = path.substring(0, path.length() - 21);
        String dest = "C:/Users/cfavre/BonPlanFront/src/assets/img/bp/" + Photoname;
        File file2 = new File(dest);
        TimeUnit.SECONDS.sleep(1);
        if (file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
            Files.delete(Paths.get(dest));
        }
        TimeUnit.SECONDS.sleep(1);
        Files.move(Paths.get(src), Paths.get(dest));
        // String UpdatePathImage = "../assets/img/bp/" + Photoname;
        File file_delete = new File(src);
        
        if (file_delete.exists()){
            Files.delete(Paths.get(src));
        }  
        String UpdatePathImage = "../assets/img/bp/" + Photoname;
    
        upBonPlan.setImageBonPlan(UpdatePathImage);
        System.out.println(upBonPlan.getImageBonPlan());

        
        bonplanService.updateThisBonPlan(upBonPlan);
    }

    @PutMapping(path= "/{city}/{activity}/updatebonplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateBonPlan(@RequestBody bonplan upBonPlan) throws IOException, InterruptedException { 
        bonplan bonplanFromDb = bonplanRepository.findById(upBonPlan.getName()).get(); 
        upBonPlan.setImageBonPlan(bonplanFromDb.getImageBonPlan());
        bonplanService.updateThisBonPlan(upBonPlan);
      }
        


    //Count bonplan
    @GetMapping(path="/{city}/{activites}/countbonplan", 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count(@PathVariable ("city") String city, @PathVariable ("activites") String activites){
        return bonplanService.count(city, activites);
    }

    //Get All BonPlan of the user
    @GetMapping(path="/{username}/AllBonPlan")
    public ResponseEntity<List<bonplan>> getUserBonPlan(@PathVariable("username") String username) {
        List<bonplan> allBP = bonplanService.getUserBonPlan(username);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }

    // // Get note du Bon plan
    // @GetMapping(path= "/{city}/{activity}/{name}/note")
    // public Integer[] getNoteBonPlan(@PathVariable("city") String city, @PathVariable("activity") String activity,
    // @PathVariable("name") String name) {
    //     return bonplanService.getNoteBonPlan(city, activity, name);
    //     }
}
