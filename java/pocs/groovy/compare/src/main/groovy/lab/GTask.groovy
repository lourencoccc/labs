package lab

import groovy.transform.EqualsAndHashCode

/**
 * Created by joaolourenco on 05/03/15.
 */
@EqualsAndHashCode
class GTask {

    String name
    int priority
    Date startDate
    Date endDate

    String toString() { "GTask{name=$name,priority=$priority," +
            "startDate=$startDate,endDate=$endDate)" }
}


