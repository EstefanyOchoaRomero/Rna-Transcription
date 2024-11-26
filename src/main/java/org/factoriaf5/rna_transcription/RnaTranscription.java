package org.factoriaf5.rna_transcription;

public class RnaTranscription {

    public String transcribe(String dnaSequence) {
        if (dnaSequence == null || dnaSequence.isEmpty()) {
            return "";
        }

        StringBuilder rnaSequence = new StringBuilder();
        for (char base : dnaSequence.toCharArray()) {
            switch (base) {
                case 'A' -> rnaSequence.append('U');
                case 'C' -> rnaSequence.append('G');
                case 'G' -> rnaSequence.append('C');
                case 'T' -> rnaSequence.append('A');
                default -> throw new IllegalArgumentException("Secuencia de ADN inválida.");
            }
        }
        return rnaSequence.toString();
    }
}
