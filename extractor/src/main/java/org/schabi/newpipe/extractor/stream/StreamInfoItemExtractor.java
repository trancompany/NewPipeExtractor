package org.schabi.newpipe.extractor.stream;

import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

import java.util.Calendar;

/*
 * Created by Christian Schabesberger on 28.02.16.
 *
 * Copyright (C) Christian Schabesberger 2016 <chris.schabesberger@mailbox.org>
 * StreamInfoItemExtractor.java is part of NewPipe.
 *
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

public interface StreamInfoItemExtractor extends InfoItemExtractor {


    /**
     * Get the stream type
     * @return the stream type
     * @throws ParsingException thrown if there is an error in the extraction
     */
    StreamType getStreamType() throws ParsingException;

    /**
     * Check if the stream is an ad.
     * @return {@code true} if the stream is an ad.
     * @throws ParsingException thrown if there is an error in the extraction
     */
    boolean isAd() throws ParsingException;

    /**
     * Get the stream duration in seconds
     * @return the stream duration in seconds
     * @throws ParsingException thrown if there is an error in the extraction
     */
    long getDuration() throws ParsingException;

    /**
     * Parses the number of views
     * @return the number of views or -1 for live streams
     * @throws ParsingException thrown if there is an error in the extraction
     */
    long getViewCount() throws ParsingException;

    /**
     * Get the uploader name
     * @return the uploader name
     * @throws ParsingException if parsing fails
     */
    String getUploaderName() throws ParsingException;

    String getUploaderUrl() throws ParsingException;

    /**
     * Extract the textual upload date of this item.
     * The original textual date provided by the service may be used if it is short;
     * otherwise the format "yyyy-MM-dd" or an locale specific version is preferred.
     *
     * @return The original textual upload date.
     * @throws ParsingException if there is an error in the extraction
     * @see #getUploadDate()
     */
    String getTextualUploadDate() throws ParsingException;

    /**
     * Extracts the upload date and time of this item and parses it.
     * <p>
     *     If the service doesn't provide an exact time, an approximation can be returned.
     *     The approximation should be marked by setting seconds and milliseconds to zero.
     *     <br>
     *     If the service doesn't provide any date at all, then {@code null} should be returned.
     * </p>
     *
     * @return The (approximated) date and time this item was uploaded or {@code null}.
     * @throws ParsingException if there is an error in the extraction
     *                          or the extracted date couldn't be parsed.
     * @see #getTextualUploadDate()
     */
    Calendar getUploadDate() throws ParsingException;

}
