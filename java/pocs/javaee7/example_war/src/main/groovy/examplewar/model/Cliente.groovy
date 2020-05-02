package examplewar.model

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by lourenco on 13/03/14.
 */
@Entity
@EqualsAndHashCode(includes = ['id'])
class Cliente implements Serializable{

    @Id
    Long id;
    String nome;
    String email;


}
