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

package us.illyohs.sinked

import us.illyohs.sinked.api.SinkedApi
import us.illyohs.sinked.api.channel.Channel
import us.illyohs.sinked.util.PluginInfo._

import com.google.inject.Inject
import ninja.leaping.configurate.ConfigurationOptions
import ninja.leaping.configurate.commented.CommentedConfigurationNode
import ninja.leaping.configurate.loader.ConfigurationLoader
import ninja.leaping.configurate.objectmapping.GuiceObjectMapperFactory
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state._
import org.spongepowered.api.plugin.Plugin

@Plugin(
  id = ID,
  name = NAME,
  version = VERSION,
  description = DESCRIPTION,
  authors = AUTHORS
)
object Sinked {

  @Inject
  private val logger: Logger = null

  @Inject
  private val factory: GuiceObjectMapperFactory = null

  @Inject
  private val loader: ConfigurationLoader[CommentedConfigurationNode] = null

  @Listener
  def serverStarting(e:GameStartingServerEvent): Unit = {
    initAPI
  }

  @Listener
  def serverStarted(e:GameStartedServerEvent): Unit = {

  }

  @Listener
  def preInit(e:GamePreInitializationEvent): Unit = {
    val node:CommentedConfigurationNode = loader.load(ConfigurationOptions.defaults().setObjectMapperFactory(factory))

  }

  @Listener
  def init(e:GameInitializationEvent): Unit = {

  }

  @Listener
  def postInit(e:GamePostInitializationEvent): Unit = {

  }

  private def initAPI: Unit = {


  }

  def getLogger: Logger = this.logger
}

