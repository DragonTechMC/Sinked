package us.illyohs.sinked.util;

import java.util.List;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class Channel
{
    @Setting(value="channel", comment="Channel name")
    private String       name;
    @Setting(value="owner", comment="Channel's owner")
    private String       owner;
    @Setting(value="password", comment="Channel's password")
    private String       password;
    @Setting(value="prefix", comment="Channel's prefix")
    private String       prefix;
    @Setting(value="suffix", comment="Channel's suffix")
    private String       suffix;
    @Setting(value="isInviteOnly", comment="Is the channel invite only")
    private boolean      isInviteOnly;
    @Setting(value="hasPassword", comment="Does the channel need a password")
    private boolean      hasPassword;
    @Setting(value="isShard", comment="Is the channel part of the cluster")
    private boolean      isShard;
    @Setting(value="invtedPlayers", comment="list of invited players")
    private List<String> invtedPlayers;
    @Setting(value="helpers", comment="List of channel helpers")
    private List<String> helpers;

}
