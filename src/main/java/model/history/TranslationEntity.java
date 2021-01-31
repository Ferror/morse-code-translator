package model.history;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Translation representation.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.1
 */
@Entity
public class TranslationEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
     * Message that user provided.
     */
    private String original;
    
    /**
     * Message that system translated.
     */
    private String translated;
    
    /**
     * Time the translation was created at.
     */
    private Timestamp createdAt;
    
    /**
     * Default constructor for Entity persistence.
     */
    public TranslationEntity()
    {
    }
    
    /**
     * Creates Translation object from timestamp.
     * 
     * @param original the message user provided.
     * @param translated message that system translated.
     * @param createdAt time the translation was created at.
     *
     * @throws TranslationHistoryException when parameters are invalid.
     */
    public TranslationEntity(String original, String translated, Timestamp createdAt) throws TranslationHistoryException
    {
        if (original == null || translated == null || createdAt == null) {
            throw new TranslationHistoryException("Nor value must be nullable");
        }
        
        this.original = original;
        this.translated = translated;
        this.createdAt = createdAt;
    }
    
    /**
     * Creates Translation object from date.
     * 
     * @param original the message user provided
     * @param translated message that system translated
     * @param createdAt time the translation was created at.
     *
     * @throws TranslationHistoryException when parameters are invalid.
     */
    public TranslationEntity(String original, String translated, Date createdAt) throws TranslationHistoryException
    {
        if (original == null || translated == null || createdAt == null) {
            throw new TranslationHistoryException("Nor value must be nullable");
        }
                
        this.original = original;
        this.translated = translated;
        this.createdAt = new Timestamp(createdAt.getTime());
    }
    
    /**
     * @return Entity identifier.
     */
    public Integer getId()
    {
        return this.id;
    }
    
    /**
     * @return the message provided by user.
     */
    public String getOriginalMessage()
    {
        return this.original;
    }
    
    /**
     * @return the message translated.
     */
    public String getTranslatedMessage()
    {
        return this.translated;
    }
    
    /**
     * @return the time when translation took place.
     */
    public Timestamp getCreatedAt()
    {
        return this.createdAt;
    }
}
