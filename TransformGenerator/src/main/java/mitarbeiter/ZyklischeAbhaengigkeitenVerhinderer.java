package mitarbeiter;

import java.util.IdentityHashMap;
import java.util.Map;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

public class ZyklischeAbhaengigkeitenVerhinderer {
    private Map<Object, Object> schonTransformierteInstanzen = new IdentityHashMap<Object, Object>();

    @BeforeMapping
    public <T> T holeAusBereitsTransformiertenInstanzen(Object quelle, @TargetType Class<T> zielTyp) {
        return (T) schonTransformierteInstanzen.get( quelle );
    }

    @BeforeMapping
    public void speichereInTransformiertenInstanzen(Object quelle, @MappingTarget Object ziel) {
        schonTransformierteInstanzen.put( quelle, ziel );
    }
}
