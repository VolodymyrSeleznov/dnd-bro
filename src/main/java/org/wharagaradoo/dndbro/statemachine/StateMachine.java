package org.wharagaradoo.dndbro.statemachine;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-16.
 */
public interface StateMachine {
    /**
     * Updates the state of this finite state machine.
     *
     * @param  event
     *         The event this state machine should use as input source
     *
     * @return True, if this state machine reached its final state
     */
    boolean updateState(MessageReceivedEvent event);
}
