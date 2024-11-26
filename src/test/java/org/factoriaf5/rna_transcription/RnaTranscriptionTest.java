package org.factoriaf5.rna_transcription;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RnaTranscriptionTest {

    public RnaTranscription rnaTranscription;

@BeforeEach
public void setUp() {
    rnaTranscription = new RnaTranscription();
}
    @Test
    void testEmptyRnaSequence() {
        assertThat(rnaTranscription.transcribe("").isEmpty(), is(true));
    }

    
    @Test
    void testRnaTranscriptionOfCytosineIsGuanine() {
        assertThat(rnaTranscription.transcribe("C"), is(equalTo("G")));
    }

    
    @Test
    void testRnaTranscriptionOfGuanineIsCytosine() {
        assertThat(rnaTranscription.transcribe("G"), is(equalTo("C")));
    }

    @Test
    void testRnaTranscriptionOfThymineIsAdenine() {
        assertThat(rnaTranscription.transcribe("T"), is(equalTo("A")));
    }

    
    @Test
    void testRnaTranscriptionOfAdenineIsUracil() {
        assertThat(rnaTranscription.transcribe("A"), is(equalTo("U")));
    }

    
    @Test
    void testRnaTranscription() {
        assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA"), is(equalTo("UGCACCAGAAUU")));
    }
}
