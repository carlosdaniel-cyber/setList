import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SongTableModel extends AbstractTableModel implements TableModelListener {
    SongDAO dao;
    List<Song> musicas;
    List<String> columns;

    public SongTableModel(SongDAO dao) {
        this.dao = dao;
        musicas =  dao.getSong();
        columns = List.of("Título", "Álbum", "Artista");
        this.addTableModelListener(this);
    }

    @Override
    public int getRowCount() {
        return musicas.size();
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Song musica = musicas.get(rowIndex);
        switch (columnIndex) {
            case 0 -> musica.setTitle((String) aValue);
            case 1 -> musica.setAlbum((String) aValue);
            case 2 -> musica.setArtist((String) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Song musica = musicas.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> musica.getTitle();
            case 1 -> musica.getAlbum();
            case 2 -> musica.getArtist();
            default -> null;
        };
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        Song musica = musicas.get(row);
        dao.update(musica);
    }

    public void addSong(String title) {
        Song musica = new Song();
        musica.setTitle(title);
        musicas.add(musica);
        dao.add(musica);
        fireTableDataChanged();
    }
}
