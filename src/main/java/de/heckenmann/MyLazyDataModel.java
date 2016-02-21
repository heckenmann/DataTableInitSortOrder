package de.heckenmann;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class MyLazyDataModel extends LazyDataModel<BeispielEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * Wird zum Vergleichen verwendet.
     * @author Ben
     *
     */
    class BeispielComparator implements Comparator<BeispielEntity> {

        private final String sortField;
        private final SortOrder sortOrder;

        public BeispielComparator(final String sortField, final SortOrder sortOrder) {
            this.sortField = sortField;
            this.sortOrder = sortOrder;
        }

        @Override
        public int compare(final BeispielEntity o1, final BeispielEntity o2) {
            try {
                final Field f = BeispielEntity.class.getDeclaredField(this.sortField);
                f.setAccessible(true);
                final String o1Value = (String) f.get(o1);
                final String o2Value = (String) f.get(o2);
                final int result = o1Value == null ? o2Value.compareTo(o1Value) : o1Value.compareTo(o2Value);
                return SortOrder.ASCENDING.equals(this.sortOrder) ? result : 0 - result;
            } catch (NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            } catch (final IllegalArgumentException e) {
                e.printStackTrace();
            } catch (final IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public MyLazyDataModel(final List<BeispielEntity> data) {
        this.setWrappedData(data);
        this.setRowCount(data.size());
    }

    /**
     * Nur zur Demo!
     */
    public static LazyDataModel<BeispielEntity> getTestInstance() {
        final List<BeispielEntity> liste = new ArrayList<>();
        liste.add(new BeispielEntity("Toller", "Wert"));
        liste.add(new BeispielEntity("Schlechter", "Inhalt"));
        final LazyDataModel<BeispielEntity> ldm = new MyLazyDataModel(liste);
        return ldm;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BeispielEntity> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder,
            final Map<String, Object> filters) {
        final List<BeispielEntity> ergebnis = (List<BeispielEntity>) this.getWrappedData();
        return ergebnis.stream().sorted(new BeispielComparator(sortField, sortOrder)).collect(Collectors.toList());
    }
}
