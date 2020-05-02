<?xml version='1.0' encoding='UTF-8'?>
<Project Type="Project" LVVersion="13008000">
	<Item Name="My Computer" Type="My Computer">
		<Property Name="server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.tcp.enabled" Type="Bool">false</Property>
		<Property Name="server.tcp.port" Type="Int">0</Property>
		<Property Name="server.tcp.serviceName" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.tcp.serviceName.default" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="specify.custom.address" Type="Bool">false</Property>
		<Item Name="test" Type="Folder">
			<Item Name="GlobalStop.vi" Type="VI" URL="../src/GlobalStop.vi"/>
			<Item Name="TestMainPage.vi" Type="VI" URL="../src/TestMainPage.vi"/>
			<Item Name="TestPage1.vi" Type="VI" URL="../src/TestPage1.vi"/>
			<Item Name="TestPage2.vi" Type="VI" URL="../src/TestPage2.vi"/>
		</Item>
		<Item Name="GlobalStopPage1.vi" Type="VI" URL="../src/GlobalStopPage1.vi"/>
		<Item Name="switch.vi" Type="VI" URL="../src/switch.vi"/>
		<Item Name="Dependencies" Type="Dependencies"/>
		<Item Name="Build Specifications" Type="Build"/>
	</Item>
</Project>
