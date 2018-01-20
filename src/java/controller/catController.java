package controller;

import dao.CatDao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.Cat;
import model.GenderEnum;

@Named(value = "catController")
@SessionScoped
public class catController implements Serializable{

    private Long id;
    private Long filterId;
    private Long removeId;
    private Long updateId;
    private Long findId;
    private Long showId;
    private String name;
    private String type;
    private String color;
    private Integer age;
    private String ownerName;
    private GenderEnum gender;
    private Date dateOfBirth;
    private String password;
    
    private List<Cat> catList;

    @Inject
    CatDao dao;
    
    Cat cat;
    
//    @PostConstruct
//    private void setup(){
//    
//    this.catList=dao.showAll();
//    }
    public catController() {
        this.cat = new Cat();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public Long getFilterId() {
        return filterId;
    }

    public void setFilterId(Long filterId) {
        this.filterId = filterId;
    }

    public Long getFindId() {
        return findId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public void setFindId(Long findId) {
        this.findId = findId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Long getRemoveId() {
        return removeId;
    }

    public void setRemoveId(Long removeId) {
        this.removeId = removeId;
    }

    public CatDao getDao() {
        return dao;
    }

    public void setDao(CatDao dao) {
        this.dao = dao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isOnlyDigits(name)) {
            this.name = name;
        }
    }

    private boolean isOnlyDigits(String string) throws IllegalArgumentException {
        if (string.matches("[0-9]+")) {
            throw new IllegalArgumentException("The string contains only numbers: " + string);
        }
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public void add() {
        System.out.println(cat.getName());
        System.out.println(cat.getAge());
        System.out.println(cat.getColor());
        System.out.println(cat.getType());
        dao.addCat(cat);
        cat = new Cat();
        info("New member created and saved");
        }
//    public String newPageMetod() {
//        FacesMessage message = new FacesMessage("Succesful, you inserted a cat");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//        return "newjsf";
//    }

    public String reset() {
        name = null;
        type = null;
        color = null;
        age = null;
        ownerName = null;
        gender = null;
        id = null;
        removeId = null;
        updateId = null;
        findId = null;
        showId = null;
        dateOfBirth = null;
        return "showOne";
    }

    public void delete() {
         dao.deleteCat(removeId);
    }
//        if (id == -1) {
//            this.error("You can not delete now, select an id first");
//            return;
//        }
//        if (! checkPassword(this.password)) {
//            this.error("Please, enter password");
//            return;
//        }
//        
//         dao.remove(dao.findCat(id));
//        info("Member information deleted");
//    }
     

    
    
     public void error(String s) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", s));
    }

  private boolean checkPassword(String p) {
        return "123".equals(p);
    }
  
    public List<Cat> showAll() {
        return dao.showAll();
    }

    public Cat showOne() {
        return dao.showOne(showId);
    }

    public void update() {
        dao.updateName(findId, name);
        dao.updateAge(findId, (int) age);
        dao.updateColor(findId, color);
        dao.updateOwnerName(findId, ownerName);
        dao.updateType(findId, type);
        dao.updateGender(findId, gender);
        dao.updateDateofBirth(findId, dateOfBirth);

    }
    
    public void info(String s) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", s));
    }


    public void find() {
        Cat c = dao.findCat(findId);

        String newName = c.getName();
        setName(newName);

        int newAge = c.getAge();
        setAge((Integer) newAge);

        String newType = c.getType();
        setType(newType);

        String newColor = c.getColor();
        setColor(newColor);

        String newOwnerName = c.getOwnerName();
        setOwnerName(newOwnerName);

        GenderEnum newGender = c.getGender();
        setGender(newGender);
        
        Date newdateOfBirth = c.getDateOfBirth();
        setDateOfBirth(newdateOfBirth);
    }

    public void showOne1() {
        Cat c = dao.findCat(showId);

        String newName = c.getName();
        setName(newName);

        int newAge = c.getAge();
        setAge((Integer) newAge);

        String newType = c.getType();
        setType(newType);

        String newColor = c.getColor();
        setColor(newColor);

        String newOwnerName = c.getOwnerName();
        setOwnerName(newOwnerName);

        GenderEnum newGender = c.getGender();
        setGender(newGender);
        
        Date newdateOfBirth = c.getDateOfBirth();
        setDateOfBirth(newdateOfBirth);
    }
//   public List<Cat> idList2(){
//      catList= dao.idList(filterId);
//      return catList;
//      
//   
//   }
//    
//     public void info() {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
//    }
}
