/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.entity.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.entity.CipherRecord;

/**
 *
 * @author Aya
 */
@Local
public interface CipherRecordFacadeLocal {

    void create(CipherRecord cipherRecord);

    void edit(CipherRecord cipherRecord);

    void remove(CipherRecord cipherRecord);

    CipherRecord find(Object id);

    List<CipherRecord> findAll();

    List<CipherRecord> findRange(int[] range);

    int count();
    // Business logic
    String encrypt(String plainText, int shift);
    String decrypt(String cipherText, int shift);
    Long totalOperations();
}
