package in.madhu;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.madhu.service.EmailSenderService;


@SpringBootApplication
public class SpringbootEmailApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("nenavathmadhu2000@gmail.com",
				"Hi , please find my resume as an attachment", "Java Developer",
			     "C:\\Users\\LENOVO\\resume.txt");

	}

}
