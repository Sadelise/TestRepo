package lukuvinkkikirjasto.domain;

import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
@Inheritance
@MappedSuperclass
public interface Tip {

    boolean markRead();
}
