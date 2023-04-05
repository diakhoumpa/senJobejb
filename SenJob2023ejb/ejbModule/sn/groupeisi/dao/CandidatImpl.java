package sn.groupeisi.dao;


import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import sn.groupeisi.entities.Candidat;
import sn.groupeisi.entities.Cv;
import sn.groupeisi.repositiry.Icandidat;

@Stateless
public  class CandidatImpl extends RepositoryImpl<Candidat> implements Icandidat {
	@PersistenceContext(unitName = "SenEuleuk")
	protected EntityManager em;
	private static final String USERNAME = "diakhoumpam@gmail.com";
	private static final String PASSWORD = "passer";

//    pour authentification
	@Override
	public Candidat authenticatecandidat(String email, String password) {
		Candidat candidat = null;
		try {
			candidat = (Candidat) em.createQuery("FROM Candidat U WHERE U.email = :email").setParameter("email", email)
					.getSingleResult();
			if (candidat != null && candidat.getPassword().equals(password)) {
				return candidat;
			}
			return null;

		} catch (Exception e) {
			return null;
		}

	}
//	pour recuperer IdCandidat
	@Override
	public Candidat getCandidatById(int id) {return em.find(Candidat.class, id);}
//	pour recuperer IdCv
	public Cv getCvByCandidatId(int candidatId) {
        Candidat candidat = em.find(Candidat.class, candidatId);
        if (candidat != null) {
            return candidat.getCv();
        } else {
            return null;
        }
    }
	
	
	
	
	
	/*
	 * public void sendEmail(String to, String subject, String body) { Properties
	 * props = new Properties();
	 * 
	 * props.put("mail.smtp.host", HOST); props.put("mail.smtp.port", PORT);
	 * props.put("mail.smtp.auth", "true");
	 * 
	 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.starttls.enable",
	 * "true"); props.put("mail.smtp.host", "smtp.gmail.com");
	 * props.put("mail.smtp.port", "587");
	 * 
	 * Authenticator auth = new Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(USERNAME,
	 * PASSWORD); } };
	 * 
	 * Session session = Session.getInstance(props, auth);
	 * 
	 * try { Message message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress(USERNAME)); message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse(to)); message.setSubject(subject);
	 * message.setText(body); Transport.send(message); } catch (MessagingException
	 * e) { e.printStackTrace(); } }
	 */
	
	
	
	
	
	

}
