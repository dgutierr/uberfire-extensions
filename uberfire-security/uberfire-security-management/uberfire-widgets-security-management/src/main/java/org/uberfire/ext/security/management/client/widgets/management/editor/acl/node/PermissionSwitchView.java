/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.uberfire.ext.security.management.client.widgets.management.editor.acl.node;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.ToggleSwitch;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.base.constants.SizeType;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Dependent
@Templated
public class PermissionSwitchView extends Composite
        implements PermissionSwitch.View {

    @Inject
    @DataField
    FlowPanel switchPanel;

    ToggleSwitch switchControl;
    PermissionSwitch presenter;

    @Override
    public void init(PermissionSwitch presenter) {
        this.presenter = presenter;
    }

    @Override
    public void init(String textOn, String textOff, boolean on) {
        switchControl = new ToggleSwitch();
        switchControl.setAnimate(true);
        switchControl.setSize(SizeType.MINI);
        if (textOn != null) {
            switchControl.setOnText(textOn);
        }
        if (textOff != null) {
            switchControl.setOffText(textOff);
        }
        switchControl.setValue(on);
        switchControl.addValueChangeHandler(event -> {
            presenter.onChange();
        });
        switchPanel.add(switchControl);
    }

    @Override
    public boolean isOn() {
        return switchControl.getValue();
    }
}