# Plugin PostFunComment for Atlassian Jira
The plugin allows you to add comment from some user when issue change status.

## Compile
1. Download and install Java JDK 1.8 from Oracle site: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Download and install Atlassian SDK from Atlassian site: https://developer.atlassian.com/server/framework/atlassian-sdk/downloads/
3. Clone git rep to local computer: **git clone https://github.com/bearchik/assignToUser.git**
4. Run **atlas-run** in folder with repo.
Your plugin in **../target/PostFunComment-1.0.0-SNAPSHOT.jar**

## Install
1. Login to Atlassian Jira with **Administrator** permission.
2. Click to **Manage apps** in administration section.
3. Click to **Manage apps** on left panel.
4. Click to **Upload app** on top.
5. Choose file **../target/PostFunComment-1.0.0-SNAPSHOT.jar**
6. Click to **Upload** button.

## Usage
1. Open Your workflow
2. Click **Edit**
3. Click on **transition** where you can change Assignee.
4. Click on **Post function**
5. Click on **Add postfunction**
6. Choose **Comment in task** and click **Add**
7. Choose **User** what will be default asignee and enter text.
8. Click **Add**
9. Enjoy

## Credentials
Author: **bearchik@gmail.com**

## License

MIT License

Copyright (c) 2019 bearchik@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.