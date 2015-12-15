package Model;

/**
 * Created by christianhasselstrom on 30/11/2015.
 */
/*
This class is for creating a Qualification object. Used when a Buyer user creates a task. Possible choices
are acquired from the database
 */
public class Qualification
{
    private String qualificationName;

    public Qualification()
    {

    }

    public Qualification(String qualificationName)
    {

    }


    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }
}
