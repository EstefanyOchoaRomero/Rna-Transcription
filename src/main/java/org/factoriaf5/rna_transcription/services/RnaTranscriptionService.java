package org.factoriaf5.rna_transcription.services;





import org.factoriaf5.rna_transcription.RnaTranscription;
import org.springframework.stereotype.Service;

@Service
public class RnaTranscriptionService {

    private final RnaTranscription rnaTranscription;

    // Constructor que inyecta la clase RnaTranscription
    public RnaTranscriptionService() {
        this.rnaTranscription = new RnaTranscription();
    }

    public String transcribe(String dnaSequence) {
        return rnaTranscription.transcribe(dnaSequence);
    }
}

