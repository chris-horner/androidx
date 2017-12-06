/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.arch.background.workmanager.constraints.controllers;

import android.arch.background.workmanager.constraints.trackers.Trackers;
import android.arch.background.workmanager.impl.WorkDatabase;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * A {@link ConstraintController} for battery not low events.
 */

public class BatteryNotLowController extends ConstraintController<Boolean> {
    public BatteryNotLowController(
            Context context,
            WorkDatabase workDatabase,
            LifecycleOwner lifecycleOwner,
            OnConstraintUpdatedCallback onConstraintUpdatedCallback,
            boolean allowPeriodic) {
        super(
                workDatabase.workSpecDao().getIdsForBatteryNotLowController(allowPeriodic),
                lifecycleOwner,
                Trackers.getInstance(context).getBatteryNotLowTracker(),
                onConstraintUpdatedCallback);
    }

    @Override
    boolean isConstrained(@NonNull Boolean isBatteryNotLow) {
        return !isBatteryNotLow;
    }
}
