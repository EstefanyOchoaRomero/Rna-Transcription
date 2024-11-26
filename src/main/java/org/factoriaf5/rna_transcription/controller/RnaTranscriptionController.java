package org.factoriaf5.rna_transcription.controller;

import javax.validation.Valid;

import org.factoriaf5.rna_transcription.models.DnaSequenceModel;
import org.factoriaf5.rna_transcription.services.RnaTranscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rna-transcription")
public class RnaTranscriptionController {

    private final RnaTranscriptionService rnaTranscriptionService;

    @Autowired
    public RnaTranscriptionController(RnaTranscriptionService rnaTranscriptionService) {
        this.rnaTranscriptionService = rnaTranscriptionService;
    }

    @PostMapping("/transcribe")
    public ResponseEntity<String> transcribeDna(@RequestBody @Valid DnaSequenceModel dnaSequence, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

    
        String rna = rnaTranscriptionService.transcribe(dnaSequence.getSequence());
        return ResponseEntity.ok(rna);
    }
}
