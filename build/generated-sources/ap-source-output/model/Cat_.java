package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GenderEnum;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-01-21T12:40:26")
@StaticMetamodel(Cat.class)
public class Cat_ { 

    public static volatile SingularAttribute<Cat, String> color;
    public static volatile SingularAttribute<Cat, String> ownerName;
    public static volatile SingularAttribute<Cat, GenderEnum> gender;
    public static volatile SingularAttribute<Cat, String> name;
    public static volatile SingularAttribute<Cat, Date> dateOfBirth;
    public static volatile SingularAttribute<Cat, Long> id;
    public static volatile SingularAttribute<Cat, String> type;
    public static volatile SingularAttribute<Cat, Integer> age;

}