/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2014 LensKit Contributors.  See CONTRIBUTORS.md.
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.data.text;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableSet;
import org.grouplens.lenskit.core.Shareable;
import org.grouplens.lenskit.data.event.EventBuilder;
import org.grouplens.lenskit.data.event.RatingBuilder;
import org.grouplens.lenskit.data.event.Ratings;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Event type for {@link org.grouplens.lenskit.data.event.Rating}s.
 *
 * @since 2.2
 */
@AutoService(EventTypeDefinition.class)
@Shareable
public class RatingEventType implements EventTypeDefinition, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String getName() {
        return "rating";
    }

    @Override
    public Class<? extends EventBuilder> getBuilderType() {
        return RatingBuilder.class;
    }

    @Override
    public RatingBuilder newBuilder() {
        return Ratings.newBuilder();
    }

    @Override
    public Set<Field> getRequiredFields() {
        return ImmutableSet.of(Fields.user(), Fields.item(), Fields.rating());
    }

    @Override
    public List<Field> getDefaultFields() {
        return Fields.list(Fields.user(),
                           Fields.item(),
                           Fields.rating(),
                           Fields.timestamp(false));
    }
}
