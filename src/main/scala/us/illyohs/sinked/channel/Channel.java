/**
 * Copyright (c) 2016, Anthony Anderson(Illyohs)
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.illyohs.sinked.channel;

import javax.annotation.Nonnull;
import java.util.List;

public class Channel
{
    String  name;
    String  owner;
    String  prefix;
    String  suffix;
    String  password;
    boolean isEnabled;
    boolean hasOwner;
    boolean isHidden;
    boolean hasPassword;
    boolean isNetworked;
    List<String> invtedUsers;

    public Channel(@Nonnull String name, @Nonnull String owner, @Nonnull String prefix, @Nonnull String suffix,
                   @Nonnull String password, @Nonnull boolean hasOwner, @Nonnull boolean isEnabled, @Nonnull boolean isHidden,
                   @Nonnull boolean hasPassword, @Nonnull boolean isNetworked)
    {
        this.name = name;
        this.owner = owner;
        this.prefix = prefix;
        this.suffix = suffix;
        this.password = password;
        this.isEnabled = isEnabled;
        this.hasOwner = hasOwner;
        this.hasPassword = hasPassword;
        this.isNetworked = isNetworked;
        this.isHidden = isHidden;
    }

    public String getName()
    {
        return name;
    }

    public String getOwner()
    {
        return owner;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isEnabled()
    {
        return isEnabled;
    }

    public boolean hasOwner()
    {
        return hasOwner;
    }

    public boolean isNetworked()
    {
        return isNetworked;
    }

    public boolean hasPassword()
    {
        return hasPassword;
    }

    public boolean isHidden()
    {
        return isHidden;
    }

}
