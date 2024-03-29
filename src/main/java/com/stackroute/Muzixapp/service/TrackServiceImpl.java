package com.stackroute.Muzixapp.service;

import com.stackroute.Muzixapp.domain.Track;
import com.stackroute.Muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TrackServiceImpl implements TrackService{
    @Value("${Track.trackId}")
    int trackId;
    @Value("${Track.trackName}")
    String trackName;
    @Value("${Track.trackComments}")
    String trackComments;
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track)  throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())){ ;
            throw new TrackAlreadyExistsException("track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack==null){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
//        Track t = new Track(trackId, trackName, trackComments);
//        trackRepository.save(t);
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException
    {
        if(!trackRepository.findById(id).isPresent()) {
            throw new TrackNotFoundException("Does not exist");
        }

        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public void deleteTrack(int id){

        trackRepository.deleteById(id);
    }
    @Override
    public Track updateTrack(Track track){
        return
                trackRepository.save(track);
    }

}