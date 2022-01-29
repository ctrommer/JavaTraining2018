package implementiertVonAnnotation;

import com.google.inject.ImplementedBy;

/**
 * Mit @ImplementedBy kann just-in-time-binding verwendet werden.
 * Die Bindung muss also nicht mehr im Binding Module angegeben werden.
 */
@ImplementedBy(SprechstundenhilfeImpl.class)
public interface Sprechstundenhilfe {
}
