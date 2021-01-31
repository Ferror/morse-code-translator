package controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.history.TranslationEntity;
import model.history.TranslationHistory;

/**
 * Stores translation history in database.
 * 
 * @author Zbigniew Malcherczyk (zbigmal353@student.polsl.pl)
 * @version 1.0
 */
public class DatabaseTranslationHistory implements TranslationHistory
{
    /**
     * Collection of translations.
     */
    private final List<TranslationEntity> history;
    
    /**
     * Database Entity Manager.
     */
    private final EntityManager em;
    
    public DatabaseTranslationHistory(EntityManager em)
    {
        this.history = new ArrayList<>();
        this.em = em;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(TranslationEntity translation)
    {
        if (translation == null) {
            throw new NullPointerException();
        }
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
            
        try {
            this.em.persist(translation);
            this.history.add(translation);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
    /**
     * Removes entity from storage.
     * 
     * @param identifier of an entity.
     */
    public void remove(int identifier)
    {
        TranslationEntity translation = em.find(TranslationEntity.class, identifier);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
            
        try {
            this.em.remove(translation);
            this.history.remove(translation);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TranslationEntity> getHistory()
    {
        List<TranslationEntity> result = this.em
            .createQuery("SELECT t FROM TranslationEntity t", TranslationEntity.class)
            .getResultList();
        
        if (result == null) {
            return this.history;
        }
        
        return result;
    }
}
