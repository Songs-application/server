package songs.components;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("songs")

public class  SongsController {

    @Autowired
    private SongsService songsService;

    // Get all songs
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SongModel> getAllSongs() {
        return songsService.getAll();
    }

    // Get all songs of a specific artist
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/byArtist/{artist}", method = RequestMethod.GET)
    public List<SongModel> getAllSongsByArtist(@PathVariable String artist) {
        return songsService.getByArtist(artist);
    }

    // Get specific song by id
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<SongModel> getSongById(@PathVariable String id) {
        return songsService.getById(id);
    }

    // Add song
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public SongModel addSong(@RequestBody SongModel newSong) {
        return songsService.add(newSong);
    }

    // Delete song by id
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteSongById(@PathVariable String id) {
         songsService.delete(id);
        return id;
    }

    // Update song
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public SongModel updateSong(@RequestBody SongModel updatedSong) {
        return songsService.update(updatedSong);
    }

}
