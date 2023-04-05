package sn.groupeisi.controller;


import java.io.IOException;


import jakarta.ejb.EJB;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import sn.groupeisi.dao.EmailService;
/*import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
*/
import sn.groupeisi.entities.Candidat;
import sn.groupeisi.entities.Cv;
import sn.groupeisi.repositiry.Icandidat;
import sn.groupeisi.repositiry.Icv;

@WebServlet("/candidat")
public class Candidatservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_PATH = "/WEB-INF/views/candidatseneuleuk/";
	@EJB
	private Icandidat candidatdao;
	@EJB
	private Icv cvdao;
	@EJB
    private EmailService emailService;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute( "email" );
		String firstname = (String) session.getAttribute( "firstname" );
		String lastname = (String) session.getAttribute( "lastname" );
		if (email !=null) {
			request.setAttribute("email", email);
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.getRequestDispatcher(VIEW_PATH+"espacecandidat.jsp").forward(request, response);
			/*
			 * if (request.getParameter("action") != null &&
			 * request.getParameter("action").equals("imprimer1")) { // Récupérer le contenu
			 * HTML de la page JSP String html = getHTMLContent(request, response); // Créer
			 * un nouveau document PDF Document document = new Document(); try { // Ouvrir
			 * le document et créer un écrivain PDF PdfWriter.getInstance(document,
			 * response.getOutputStream()); document.open(); // Convertir le contenu HTML en
			 * PDF et l'ajouter au document HTMLWorker htmlWorker = new
			 * HTMLWorker(document); htmlWorker.parse(new StringReader(html)); } catch
			 * (Exception e) { // Gérer les erreurs } finally { // Fermer le document
			 * document.close(); }
			 * 
			 * }
			 */
		}else {
			request.setAttribute("error", "Veillez-vous authentifier svp !");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
	/*
	 * private String getHTMLContent(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // Utiliser un
	 * RequestDispatcher pour inclure la page JSP dans la servlet RequestDispatcher
	 * dispatcher = request.getRequestDispatcher(VIEW_PATH+"cvreport.jsp");
	 * StringWriter stringWriter = new StringWriter(); PrintWriter printWriter = new
	 * PrintWriter(stringWriter); HttpServletResponseWrapper wrapper = new
	 * HttpServletResponseWrapper(response) { public PrintWriter getWriter() {
	 * return printWriter; } }; dispatcher.include(request, wrapper);
	 * 
	 * // Retourner le contenu HTML de la page JSP return stringWriter.toString(); }
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
	    Candidat candidat =new Candidat();
		if (action.equals("enregistrer")) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (firstname.isEmpty()&lastname.isEmpty()&email.isEmpty()&password.isEmpty()) {
				request.setAttribute("errorremplir", "veuillez remplir tous les champs*");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				candidat.setFirstname(firstname);
				candidat.setLastname(lastname);
				candidat.setEmail(email);
				candidat.setPassword(password);
				candidatdao.add(candidat);
				
				//String subject="vos informations apres inscriptions"+"Prenom:"+firstname+"Nom:"+lastname;
            	//String body="Merci!!!";
//            	try {
//					mailsender.sendEmail(email ,subject, body);
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				// Envoyer un e-mail de bienvenue
		        String to = candidat.getEmail();
		        String subject = "Bienvenue sur notre site";
		        String body = "Bonjour " + candidat.getFirstname() + ",\n\n" +
		                      "Merci de vous être inscrit sur notre site.\n\n" +
		                      "Cordialement,\n" +
		                      "L'équipe du site";
		        try {
		            emailService.sendEmail(to, subject, body);
		        } catch (MessagingException e) {
		            // Gérer les erreurs d'envoi de courrier électronique
		        }
				request.setAttribute("message", "vos informations de connexion vous ont été envoyé par mail *");
            	request.getRequestDispatcher("index.jsp").forward(request, response);
                
				
			}
			
		}
		//si action est egale a enregistrer CV
		else {
			Integer  id = (int) session.getAttribute( "id" );
			if (action.equals("enregistrerCv")) {
				String firstnamecv = request.getParameter("firstname");
				String lastnamecv = request.getParameter("lastname");
				String emailcv = request.getParameter("email");
				String address = request.getParameter("address");
				String  ageString = request.getParameter("age");
				String  specialite = request.getParameter("specialite");
				String  niveauEtude = request.getParameter("niveauetude");
				String  experience = request.getParameter("experience");
                //			    verification des champs 
				if (firstnamecv.isEmpty()||lastnamecv.isEmpty()||emailcv.isEmpty()||address.isEmpty()||specialite.isEmpty()||niveauEtude.isEmpty()||experience.isEmpty()||id==null) {
					 request.setAttribute("errorremplir", "veuillez remplir tous les champs*");
					 request.getRequestDispatcher(VIEW_PATH+"espacecandidat.jsp").forward(request, response);
				}else {
                     //				    test pour verifier si entier est nulll
					 if ( ageString!= null && !ageString.isEmpty()) {
						try {
							int age=Integer.parseInt(ageString);
							Cv cv =new Cv();
							cv.setFirstname(firstnamecv);
							cv.setLastname(lastnamecv);
							cv.setAdresse(address);
							cv.setEmail(emailcv);
							cv.setAge(age);
							cv.setExperienceProfessionnelle(experience);
							cv.setNiveauEtude(niveauEtude);
							cv.setSpecialite(specialite);
							Candidat idcandidat = candidatdao.getCandidatById(id); // Récupère le candidat par son identifiant
							cv.setCandidat(idcandidat);
							cvdao.add(cv);	
							request.setAttribute("success", "votre  Cv est cree*");
							request.getRequestDispatcher(VIEW_PATH+"espacecandidat.jsp").forward(request, response);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}}
					 }
		}else {
			if (action.equals("report")){
				String email = (String) session.getAttribute( "email" );
				if (email!= null) {
					Integer  id1 = (int) session.getAttribute( "id" );
					// Récupération des informations du candidat depuis la base de données
					Candidat candidatinfo= candidatdao.get(id1, candidat);
					Cv cv = candidatdao.getCvByCandidatId(id1);
					 if (cv != null) {
					        // Afficher les informations du CV
						    request.setAttribute("candidat", candidatinfo);
							request.setAttribute("cv", cv);
							System.out.println("============================================"+cv);
							request.getRequestDispatcher(VIEW_PATH+"cvreport.jsp").forward(request, response);
							if (action.equals("imprimer")) {
								
							}
							
					    } else {
					        // Gérer le cas où le candidat n'a pas de CV enregistré
					    	request.getRequestDispatcher(VIEW_PATH+"espacecandidat.jsp").forward(request, response);
					    }
					// Stockage du candidat en tant qu'attribut de la requête
					
					
				}
				
			}
		}
	}
}
}
