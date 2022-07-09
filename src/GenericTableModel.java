import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class GenericTableModel<T> extends AbstractTableModel {
    private AbstractDAO<T> dao;
    private List<T> data;

    public GenericTableModel (AbstractDAO<T> dao) {
        this.dao = dao;
        data = dao.retrieve();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        Object obj = data.get(0);
        Class  c = obj.getClass();
        int sum = 0;
        for (Field f: c.getDeclaredFields() ) {
            if (f.isAnnotationPresent(ColunaAnnotation.class)  ) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public String getColumnName(int column) {
        Object obj = data.get(0);
        Class  c = obj.getClass();
        for (Field f: c.getDeclaredFields() ) {
            if (f.isAnnotationPresent(ColunaAnnotation.class)  ) {
                ColunaAnnotation a = (ColunaAnnotation)f.getAnnotation(ColunaAnnotation.class);
                if (a.pos() == column) {
                    return a.name();
                }
            }
        }
        return null;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = data.get(rowIndex);
        Class c = objeto.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields) {
            if (f.isAnnotationPresent(ColunaAnnotation.class)) {
                ColunaAnnotation annotation = f.getAnnotation(ColunaAnnotation.class);
                if (columnIndex == annotation.pos()) {
                    String attrName = f.getName();
                    String methodName = "get" +
                            attrName.substring(0,1).toUpperCase()
                            + attrName.substring(1);
                    try {
                        Method m = c.getDeclaredMethod(methodName);
                        Object value = m.invoke(objeto);
                        return value;

                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return null;
    }
}
