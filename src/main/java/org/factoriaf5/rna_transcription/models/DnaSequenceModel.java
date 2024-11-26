package org.factoriaf5.rna_transcription.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class DnaSequenceModel {

    @NotBlank(message = "La secuencia de ADN no puede estar vacía.")
    @Pattern(regexp = "^[ACGT]+$", message = "La secuencia de ADN solo puede contener los caracteres A, C, G, T.")
    private String sequence;

    
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
