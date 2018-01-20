package dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cat;
import model.GenderEnum;

@Stateless
public class CatDao {

    @PersistenceContext(unitName = "PetCatCarePU")
    private EntityManager em;

    public void addCat( Cat cat){
    em.persist(cat);
    }
   
  public void deleteCat(Long id) {
       Cat cat = em.find(Cat.class,id);
        em.remove(cat);
    }
//     public void remove(Cat entity) {
//        em.remove(em.merge(entity));
//    }

    public List<Cat> showAll(){
        return (List<Cat>)em.createQuery("SELECT e FROM Cat e").getResultList();
    }
    
    public Cat showOne(Long id){
       return em.find(Cat.class, id);
   
    }
    public void updateName(Long id,String name){
        Cat c=em.find(Cat.class, id);
        c.setName(name);
        em.persist(c);
    
    }
     public void updateAge(Long id,int age){
        Cat c=em.find(Cat.class, id);
        c.setAge(age);
        em.persist(c);
    
    }
      public void updateOwnerName(Long id,String owner){
        Cat c=em.find(Cat.class, id);
        c.setOwnerName(owner);
        em.persist(c);
    
    }
      public void updateColor(Long id,String color){
        Cat c=em.find(Cat.class, id);
        c.setColor(color);
        em.persist(c);
    
    }
      public void updateType(Long id,String type){
        Cat c=em.find(Cat.class, id);
        c.setType(type);
        em.persist(c);
    
    }
      public void updateGender(Long id,GenderEnum gender){
      Cat c=em.find(Cat.class, id);
        c.setGender((GenderEnum) gender);
        em.persist(c);
      }
      public void updateDateofBirth(Long id, Date dateofBirth){
      Cat c=em.find(Cat.class, id);
        c.setDateOfBirth(dateofBirth);
        em.persist(c);
      }
     
    
    public Cat findCat(Long id){
        return em.find(Cat.class, id);
    
    }
//   public List<Cat> nameList(String name){
//       return em.createQuery("SELECT e FROM Cat e WHERE e.name=:name").getResultList();
//        
//    }
//   public List<Cat> idList(Long id){
//       return em.createQuery("SELECT e FROM Cat e WHERE e.id=:id").getResultList();
//        
//    }
    
}
