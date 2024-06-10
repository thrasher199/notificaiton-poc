import { protectRoutes } from '@hilla/react-auth';
import HelloWorldView from 'Frontend/views/helloworld/HelloWorldView.js';
import LoginView from 'Frontend/views/login/LoginView.js';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, RouteObject } from 'react-router-dom';
import UserDetailsView from "Frontend/views/userdetail/UserDetailsView";
import NotificationView from "Frontend/views/notification/NotificationView";

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));

const routing = protectRoutes([
  {
    element: <MainLayout />,
    handle: { title: 'Main' },
    children: [
      { path: '/', element: <HelloWorldView />, handle: { title: 'Hello World', requiresLogin: true } },
      { path: '/about', element: <AboutView />, handle: { title: 'About', requiresLogin: true } },
      { path: '/user', element: <UserDetailsView />, handle: { title: 'User Details', requiresLogin: true } },
      { path: '/notification', element: <NotificationView />, handle: { title: 'Notification', requiresLogin: true } },
    ],
  },
  { path: '/login', element: <LoginView /> },
]) as RouteObject[];

export const routes = routing;
export default createBrowserRouter(routes);
