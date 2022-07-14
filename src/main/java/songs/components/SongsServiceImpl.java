package songs.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsServiceImpl implements SongsService {

  @Autowired
    private SongsRepo songsRepo;

    @Override
    public List<SongModel> getAll() {
        return songsRepo.findAll();
    }

    @Override
    public List<SongModel> getByArtist(String artist) {
        return songsRepo.findByArtist(artist);
    }

    @Override
    public Optional<SongModel> getById(String id) {
        return songsRepo.findById(id);
    }

    @Override
    public SongModel add(SongModel song) {
        songsRepo.save(song);
        return song;
    }

    @Override
    public boolean delete(String id) {
        songsRepo.deleteById(id);
        return true;
    }

    @Override
    public SongModel update(SongModel updatedSong) {
        songsRepo.save(updatedSong);
        return updatedSong;
    }

}