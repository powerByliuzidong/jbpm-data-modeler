/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.datamodeler.client.perspectives;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Generated;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.uberfire.client.workbench.annotations.Identifier;
import org.uberfire.client.workbench.model.PerspectiveDefinition;
import org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity;
import org.uberfire.client.mvp.PlaceManager;

import org.uberfire.shared.mvp.PlaceRequest;

@Dependent
@Generated("org.uberfire.annotations.processors.WorkbenchPerspectiveProcessor")
@Identifier("homePerspective")
/*
 * WARNING! This class is generated. Do not modify.
 */
public class HomePerspectiveActivity extends AbstractWorkbenchPerspectiveActivity {

    private static final Collection<String> ROLES = Collections.emptyList();

    private static final Collection<String> TRAITS = Collections.emptyList();

    @Inject
    private HomePerspective realPresenter;

    @Inject
    //Constructor injection for testing
    public HomePerspectiveActivity(final PlaceManager placeManager) {
        super( placeManager );
    }

    @Override
    public String getIdentifier() {
        return "homePerspective";
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public PerspectiveDefinition getPerspective() {
        return realPresenter.buildPerspective();
    }

    @Override
    public Collection<String> getRoles() {
        return ROLES;
    }

    @Override
    public Collection<String> getTraits() {
        return TRAITS;
    }

    @Override
    public String getSignatureId() {
        return "org.jbpm.datamodeler.client.perspectives.HomePerspectiveActivity";
    }
}