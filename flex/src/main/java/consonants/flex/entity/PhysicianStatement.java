package consonants.flex.entity;

import org.bson.types.ObjectId;

public class PhysicianStatement extends Form{
    public PhysicianStatement(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned){
        super(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned);
    };
}
