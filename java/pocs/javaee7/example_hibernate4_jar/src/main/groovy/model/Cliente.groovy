package model

import javax.json.Json
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by lourenco on 13/03/14.
 */
@Entity
class Cliente implements Serializable{

    @Id
    Long id;
    String nome;
    String email;


}
