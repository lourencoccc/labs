package poc.businessrules;

import java.math.BigDecimal;
import java.util.Date;


public class InvoiceDTO {

    String id;
    String type;
    BigDecimal originalValue;
    Date originalDueDate;
    BigDecimal updatedValue;
    Date updatedDueDate;
}
