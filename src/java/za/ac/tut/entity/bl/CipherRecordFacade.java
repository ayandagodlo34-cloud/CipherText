/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import za.ac.tut.entity.CipherRecord;

/**
 *
 * @author Aya
 */
@Stateless
public class CipherRecordFacade extends AbstractFacade<CipherRecord> implements CipherRecordFacadeLocal {

    @PersistenceContext(unitName = "CipherWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CipherRecordFacade() {
        super(CipherRecord.class);
    }
    
     
   
    @Override
    public String encrypt(String plainText, int shift) {
        if (plainText == null || plainText.isEmpty()) return "";
        return caesar(plainText, shift);
    }

    /**
     * Decrypt is the same as encrypt with the reverse shift.
     */
    @Override
    public String decrypt(String cipherText, int shift) {
        if (cipherText == null || cipherText.isEmpty()) return "";
        return caesar(cipherText, -shift);
    }

    private String caesar(String text, int shift) {
        // Normalize shift to 0..25
        int key = ((shift % 26) + 26) % 26;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - base + key) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public Long totalOperations() {
        return em.createQuery("SELECT COUNT(c) FROM CipherRecord c", Long.class)
                 .getSingleResult();
    }
}
