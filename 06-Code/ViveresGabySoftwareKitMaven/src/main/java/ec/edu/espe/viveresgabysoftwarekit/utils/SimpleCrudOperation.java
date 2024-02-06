
package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.List;

/**
 *
 * @author mateo
 */
public interface SimpleCrudOperation<T> {
    public List<T> readJSONListGeneric(String collectionName, Class<T> classTarget);
    public void saveCollection(List<T> templateList, String collectionName);
}
