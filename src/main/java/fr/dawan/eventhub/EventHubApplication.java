package fr.dawan.eventhub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dawan.eventhub.Enum.TypeEvent;
import fr.dawan.eventhub.entities.Event;
import fr.dawan.eventhub.entities.User;
import fr.dawan.eventhub.feathers.Feather;
import fr.dawan.eventhub.service.EventService;
import fr.dawan.eventhub.service.UserService;

@SpringBootApplication
public class EventHubApplication implements CommandLineRunner{

	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	
	private Feather feather=new Feather();
	private String pathfolder="./images/";
	private Object[] eventAndImg;
	private TypeEvent typeEvent;
	
	private String description="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed distinctio recusandae, similique, beatae dolorem harum officiis aperiam quia nulla quasi sunt omnis culpa optio? Eos, animi sequi. Repellat, aliquam modi?";
	private String resume="Lorem ipsum dolor sit amet, consectetur adipisicing elit.";
	private Map<TypeEvent, List<String>> mapEventImgs=new HashMap<TypeEvent, List<String>>();;
	
	public User userRandom() {
		List<User> users=userService.findAll();
		System.out.println(users);
		return users.get(new Random().nextInt(users.size()));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EventHubApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		List<String> imgs=feather.recoveryFileNameImage(pathfolder);
		mapEventImgs.put(TypeEvent.ART, Arrays.asList("artAnePhasmeEtBaton.jpg","artArtDesAffichistes.jpg","artPierreSecrete.jpg","artUrbanArtFair.jpg"));
		mapEventImgs.put(TypeEvent.AUTRE, Arrays.asList("autreAtelierReliureJaponais.jpg","autreBrocantePucierFarandole.jpg","autreConcoursDeBelote.jpg","autreCultureDeLaSpiruline.jpg"));
		mapEventImgs.put(TypeEvent.CULTUREL, Arrays.asList("cultureDocumentTerre-LaPerleDeLAdriatique.jpg","cultureMathematicienEtHommePolitique.jpg","cultureMontagnePluriel.jpg","cultureParenthes-culturel.jpg","cultureRaconteMoiLOurs.jpg"));
		mapEventImgs.put(TypeEvent.EXPO, Arrays.asList("expoBijouBijoux.jpg","expoLaMontagneLumineuse.jpg","expoLesViesAntérieures.jpg","expoReineMazoyer.jpg"));
		mapEventImgs.put(TypeEvent.MUSIQUE, Arrays.asList("musiqueDeadwood.jpg","musiqueMozart.jpg","musiqueSerenade.jpg","musiqueSoulcage.jpg","musiqueUnlimited.jpg"));
		mapEventImgs.put(TypeEvent.SPORTIF, Arrays.asList("sportifFamille-luge.jpg","sportifHockey-sur-glace.jpg","sportifMontagne.jpg","sportifRando.jpg"));
		
//		for(int i=0; i < 10; i++) {
//			User user=new User(feather.addFakerPseudo(), feather.addRole(), feather.addFakerFirstname(), feather.addFakerLastname(), feather.addFeatherEmail(), feather.addFakerPassword());
//			userService.createUser(user);
//		}
		
//		for (int i = 0; i < 100; i++) 
//		{
//			eventAndImg = feather.eventAndImgRandom(mapEventImgs);
//			typeEvent = (TypeEvent) eventAndImg[0];
//			eventService.createEvent(new Event(
//					typeEvent,
//					feather.addFakerTitre(), 
//					description, 
//					resume, 
//					feather.addFakerDateTime("2023-01-01T00:00:00", "2023-03-01T00:00:00"), 
//					feather.addFakerLieu(), feather.addFakerPrix(), feather.converterFileImgToByteArray(pathfolder, (String)eventAndImg[1]), 
//					userRandom()));
//		}
	}
}
