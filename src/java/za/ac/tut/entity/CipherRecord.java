/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Aya
 */
@Entity
public class CipherRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 500)
    private String originalText;

    @Column(length = 500)
    private String processedText;

    private String operation;      // "Encrypt" or "Decrypt"
    private Integer shiftKey;
    private LocalDateTime timestamp;

    public CipherRecord() {
    }

    public CipherRecord(String originalText, String processedText,
                        String operation, Integer shiftKey) {
        this.originalText = originalText;
        this.processedText = processedText;
        this.operation = operation;
        this.shiftKey = shiftKey;
        this.timestamp = LocalDateTime.now();
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getProcessedText() {
        return processedText;
    }

    public void setProcessedText(String processedText) {
        this.processedText = processedText;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getShiftKey() {
        return shiftKey;
    }

    public void setShiftKey(Integer shiftKey) {
        this.shiftKey = shiftKey;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CipherRecord)) {
            return false;
        }
        CipherRecord other = (CipherRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entity.CipherRecord[ id=" + id + " ]";
    }
    
}
