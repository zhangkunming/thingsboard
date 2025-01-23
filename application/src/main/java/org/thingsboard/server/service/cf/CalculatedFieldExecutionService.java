/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.cf;

import org.thingsboard.rule.engine.api.TimeseriesSaveRequest;
import org.thingsboard.server.common.data.kv.TimeseriesSaveResult;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.service.cf.telemetry.CalculatedFieldTelemetryUpdateRequest;

public interface CalculatedFieldExecutionService {

    /**
     * Filter CFs based on the request entity. Push to the queue if any matching CF exist;
     * @param request - telemetry save request;
     * @param request - telemetry save result;
     */
    void pushRequestToQueue(TimeseriesSaveRequest request, TimeseriesSaveResult result);

//    void pushEntityUpdateMsg(TransportProtos.CalculatedFieldEntityUpdateMsgProto proto, TbCallback callback);

    /*  ===================================================== */

    void onCalculatedFieldMsg(TransportProtos.CalculatedFieldMsgProto proto, TbCallback callback);

    void onTelemetryUpdate(CalculatedFieldTelemetryUpdateRequest calculatedFieldTelemetryUpdateRequest);

    void onTelemetryUpdateMsg(TransportProtos.TelemetryUpdateMsgProto proto);

    void onEntityProfileChangedMsg(TransportProtos.EntityProfileUpdateMsgProto proto, TbCallback callback);

    void onProfileEntityMsg(TransportProtos.ProfileEntityMsgProto proto, TbCallback callback);

}
