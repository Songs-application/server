package songs.components;

import java.util.List;
import java.util.Optional;

public interface SongsService {
    
    public List<SongModel> getAll();

    public List<SongModel> getByArtist(String artist);

    public Optional<SongModel> getById(String id);

    public SongModel add(SongModel s);

    public boolean delete(String id);

    public SongModel update(SongModel updatedSong);
}
