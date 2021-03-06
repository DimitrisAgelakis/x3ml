package eu.delving.x3ml.engine;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @author Gerald de Jong <gerald@delving.eu>
 */

@XStreamAlias("mappings")
public class Mappings {

    @XStreamAsAttribute
    public String version;

    public Metadata metadata;

    public List<MappingConstant> mappingConstants;

    @XStreamImplicit
    public List<Mapping> mappings;

    public void apply(Context context) {
        for (Mapping mapping : mappings) {
            context.setNode(null);
            mapping.apply(context);
        }
    }
}
