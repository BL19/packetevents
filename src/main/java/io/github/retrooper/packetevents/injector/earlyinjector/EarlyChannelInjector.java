/*
 * MIT License
 *
 * Copyright (c) 2020 retrooper
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.retrooper.packetevents.injector.earlyinjector;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.injector.ChannelInjector;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class EarlyChannelInjector implements ChannelInjector {
    private EarlyChannelInjector7 injector7;
    private EarlyChannelInjector8 injector8;
    private boolean outdatedInjectorMode = false;

    public EarlyChannelInjector(final Plugin plugin) {
        if (PacketEvents.get().getServerUtils().getVersion() == ServerVersion.v_1_7_10) {
            injector7 = new EarlyChannelInjector7(plugin);
            this.outdatedInjectorMode = true;
        } else {
            injector8 = new EarlyChannelInjector8(plugin);
        }
    }

    public void startup() {
        if (outdatedInjectorMode) {
            injector7.startup();
        } else {
            injector8.startup();
        }
    }

    public void close() {
        if (outdatedInjectorMode) {
            injector7.close();
        } else {
            injector8.close();
        }
    }

    public void closeAsync() {
        PacketEvents.get().packetHandlingExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                close();
            }
        });
    }

    @Override
    public void injectPlayerSync(Player player) {
        if (outdatedInjectorMode) {
            injector7.injectPlayerSync(player);
        } else {
            injector8.injectPlayerSync(player);
        }
    }

    @Override
    public void ejectPlayerSync(Player player) {
        if (outdatedInjectorMode) {
            injector7.ejectPlayerSync(player);
        } else {
            injector8.ejectPlayerSync(player);
        }
    }

    @Override
    public void injectPlayerAsync(Player player) {
        if (outdatedInjectorMode) {
            injector7.injectPlayerAsync(player);
        } else {
            injector8.injectPlayerAsync(player);
        }
    }

    @Override
    public void ejectPlayerAsync(Player player) {
        if (outdatedInjectorMode) {
            injector7.ejectPlayerAsync(player);
        } else {
            injector8.ejectPlayerAsync(player);
        }
    }

    @Override
    public void sendPacket(Object channel, Object packet) {
        if (outdatedInjectorMode) {
            injector7.sendPacket(channel, packet);
        } else {
            injector8.sendPacket(channel, packet);
        }
    }
}